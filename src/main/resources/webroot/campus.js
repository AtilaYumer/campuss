var app = angular.module('campusApp', []);

app.controller('CampusController', ["$scope", "$http", "$timeout", function ($scope, $http, $timeout){
    $scope.title = 'Campus';
    $scope.text = 'Welcome to campus website!';
}]);
