var app = angular.module('myApp', ['ui.router']);

app.config(function($stateProvider,$urlRouterProvider,$locationProvider){
    $urlRouterProvider.otherwise('/welcome');
    $locationProvider.hashPrefix('');
    $stateProvider
        .state('welcome',{
            url:'/welcome',
            templateUrl: 'http://localhost:8080/zyhtweb/html/welcome.html'
        })
        .state('customer',{
            url:'/customer',
            templateUrl: 'http://localhost:8080/zyhtweb/html/customerInformation.html',
            controller:'customerController'
        })
        .state('packageInformation',{
            url:'/packageInformation',
            templateUrl:'http://localhost:8080/zyhtweb/html/packageInformation.html',
            controller:'packageInformationController'
        })
        .state('footer',{
            url:'/footer',
            templateUrl:'http://localhost:8080/zyhtweb/html/footer.html'
        })
});

app.controller('customerController',function($scope,$http){
    $http({
        method: 'post',
        url: '/zyhtweb/action/angular!findAllCustomer.do'
    }).then(function successCallBack(response){
        $scope.customers = response.data;
    },function errorCallBack(response){
        alert("错误");
    })
});
app.controller('packageInformationController',function($scope,$http){
    $http({
        method: 'post',
        url: '/zyhtweb/action/package-information!findAllPackageInformation.do'
    }).then(function successCallBack(response){
        $scope.packageInformations = response.data;
    },function errorCallBack(response){
        alert("错误");
    })
});