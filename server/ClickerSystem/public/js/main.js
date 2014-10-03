'use strict';

console.log("Test");

var clickerSystem = angular.module('clickerSystem', [
    'ngRoute', 'angular.directives-chartjs-doughnut','ngCookies'
]);

clickerSystem.config(['$routeProvider', function($routeProvider) {
       $routeProvider.
            when('/signIn', {
                templateUrl: 'partials/signIn.html',
                controller: 'signInController'
            }).
            when('/question', {
                templateUrl: 'partials/question.html',
                controller:  'questionController'
            }).
            when('/summary', {
                templateUrl: 'partials/summary.html',
                controller:  'summaryController'
            }).
            when('/session',{
                templateUrl: 'partials/session.html',
                controller:  'sessionController'
            }).
            when('/teacherSet', {
                templateUrl: 'partials/teacherSet.html',
                controller: 'teacherSetController'
            }).
            otherwise({
                redirectTo: '/signIn'
            });
}]);