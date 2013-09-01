var logEnabled = false;

function slog(o) {
	if (console && logEnabled) {
		console.log(o);
	}
}

var app = angular.module("Shout", []);

app.service("ShoutService", ['$rootScope', '$http', function($rootScope, $http) {
	
	this.shout = function(eventName, endpoint, message) {
		$http({
			method: 'POST',
			url: endpoint,
			data: $.param({action: 'shout', message: message}),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		});
		// broadcast response here
	};
	
	this.subscribe = function(eventName, endpoint) {
		// http://stackoverflow.com/questions/12928840/angularjs-service-broadcast-and-watch-not-triggering-on-receiving-controller
		// init atmosphere.js here and subscribe to long polling url
		//return;
		var socket = $.atmosphere;
		var request = {
				url: endpoint,
				transport: 'long-polling',
				logLevel: 'debug',
				contentType: 'text/html'
		};
		
		request.onMessage = function(response) {
			slog("Response received: " + response.responseBody);
			slog(response);
			// check if response is valid, broadcast response
			$rootScope.$apply(function(){
				$rootScope.$broadcast(eventName, angular.fromJson(response.responseBody));
			});
		};
		
		request.onReconnect = function() {
			slog("reconnect");
		};
		
		
		socket.subscribe(request);
	};
	
	this.getShouts = function(eventName, endpoint, timestamp) {
		$http({
			method: 'POST',
			url: endpoint,
			data: $.param({action: 'getshouts', time: timestamp}),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data, status){
			// data is automatically jsonified
			$rootScope.$broadcast(eventName, data);
		});
	};
	
}]);

app.directive("ticker", function() {
	return {
		restrict: 'E',
		transclude: true,
		scope: {
			scopeId: '='
		},
		controller: ['$scope', '$element', '$attrs', 'ShoutService', function($scope, $element, $attrs, ShoutService) {
			var endpoint = $attrs.endpoint;
			slog("initcontroller: " + endpoint);
			
			$scope.messages = [];
			var timestamp = $scope.timestamp = -1;
			
			ShoutService.getShouts('initialized', endpoint, timestamp);
			
			$scope.$on('oldershoutsfetched', function(event, response) {
				if (response && response.length > 0) {
					$scope.timestamp = response[response.length - 1].time;
					$scope.messages = $scope.messages.concat(response);
					// scroll to bottom (TODO: adjust scroll logic)
					var shoutsElem = $element.find('.shouts');
					shoutsElem.scrollTop(shoutsElem[0].scrollHeight);
				} else {
					// TODO: set this based on retrieved messages count!!
					$scope.timestamp = -1;
				}
				
			});
			
			$scope.$on('initialized', function(event, response) {
				slog("initialized: " + response);
				if (response) {
					$scope.messages = response;
					$scope.timestamp = response[response.length - 1].time;
				}
				
				// subscribe to events
				ShoutService.subscribe('shouted', endpoint + "&action=subscribe");
			});
			
			// listen for incoming messages
			$scope.$on('shouted', function(event, response) {
				if (angular.isObject(response)) {
					$scope.messages.unshift(response);
				} else if (angular.isArray(response)) {
					// TEST !!!
					$scope.messages = response.concat($scope.messages);
					$scope.$apply();
				}
				
			});
			
			$scope.postMessage = function(message) {
				slog("addMessage");
				ShoutService.shout('shoutResponse', endpoint, message);
				$scope.newMessage = "";
			};
			
			$scope.removeMessage = function(id) {
				var messages = $scope.messages;
				for (var i = 0; i < messages.length; i++) {
					if (messages[i].id == id) {
						messages.splice(i, 1);
						break;
					}
				}
			};
			
			$scope.loadOlderMessages = function() {
				ShoutService.getShouts('oldershoutsfetched', endpoint, $scope.timestamp);
			};
		}],
		template:
			'<div class="shoutbox">' +
				'<div class="shoutInputContainer">' +
					'<div class="shoutInputLeft"></div>' +
					'<div class="shoutInputWrapper">' +
						'<input type="text" value="" size="230" ng-model="newMessage" fire-on-key on-key="postMessage(newMessage)" key="13" />' +
					'</div>' +
					'<div class="shoutPublish" ng-click="postMessage(newMessage)"></div>' +
				'</div>' +
				'<div class="shouts">' +
					'<tick ng-repeat="message in messages" message="message" on-delete="removeMessage" fade-in></tick>' +
				'</div>' +
				'<div class="load-button" ng-show="timestamp != -1" ng-click="loadOlderMessages()"></div>' +
			'</div>',
		replace: true
	};
	
});

/**
** http://stackoverflow.com/questions/15622863/angularjs-directive-controllers-requiring-parent-directive-controllers
** http://stackoverflow.com/questions/14657591/how-do-you-access-an-ng-repeat-item-in-a-directives-scope
** http://ramandv.com/blog/angular-js-sharing-data/
**/
app.directive("tick", function() {
	return {
		restrict: 'E',
		require: '^ticker',
		transclude: true,
		scope: {
			message: '=',
			onDelete: '='
		},
		link: function($scope, $element, $attrs, $tickerCtrl) {
		},
		controller: ['$scope', '$element', function($scope, $element) {
			$scope.remove = function() {
				slog("delete");
				$($element).fadeOut('slow', function() {
					$scope.onDelete($scope.message.id);
				});
			};
		}],
		template:
			'<div class="shout">' +
				'<img class="avatar" ng-src="{{message.avatarURL}}"/>' +
				'<div class="shoutMeta">' +
					'<span class="author">{{message.displayName}} </span>' +
					'<span class="date">{{message.time | date:"short"}}</span>' +
					'<span class="controls" ng-show="false">[ <a href="#">Delete</a> ]</span>' +
				'</div>' +
				'<div class="shoutContent">{{message.message}}</div>' +
			'</div>',
		replace: true
	};
});

app.directive("fireOnKey", function() {
	return {
		restrict: 'A',
		link: function($scope, $elem, $attrs) {
			var key = $attrs.key;
			$elem.bind("keyup", function(event) {
				if (event.keyCode == key) {
					$scope.$eval($attrs.onKey);
					$scope.$apply();
				}
			});
		}
	};
});

app.directive("fadeIn", function() {
	return {
		restrict: 'A',
		link: function($scope, $elem) {
			slog($elem);
			$($elem).fadeIn(1000);
		}
	}
});