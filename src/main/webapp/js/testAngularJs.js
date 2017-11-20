var app = angular.module('myApp', ['ui.router']);
app.controller("changeCase", function($scope){
    $scope.lowCase = "abc";
});
app.controller("customer", function($scope,$http){
    $http({
        method: 'post',
        url: '/zyhtweb/action/angular!findAllCustomer.do'
    }).then(function successCallBack(response){
        $scope.customers = response.data;
    },function errorCallBack(response){
        alert("错误");
    })
});

app.component("pageHeader", {
    templateUrl:"http://localhost:8080/zyhtweb/html/head.html",
    controller:function($scope) {

    }
});
app.component("pageSlide", {
    templateUrl:"http://localhost:8080/zyhtweb/html/carousel.html",
    controller:function($scope) {

    }
});
app.component("pageFooter", {
    templateUrl:"http://localhost:8080/zyhtweb/html/footer.html",
    controller:function($scope) {

    }
});

app.controller("timeout", function($scope,$timeout){
   $scope.myTime="Hello World!";
    $timeout(function(){
        $scope.myTime="How Are You!!";
    },5000);
});

app.controller("interval", function($scope,$interval){
    $scope.myInterval = new Date().toLocaleTimeString();
    $interval(function(){
        $scope.myInterval = new Date().toLocaleTimeString();
    },1000);
});

app.config(function($stateProvider,$urlRouterProvider,$locationProvider){
    $urlRouterProvider.otherwise('/head');
    $locationProvider.hashPrefix('');
    $stateProvider
        .state('head',{
            url:'/head',
            templateUrl: 'http://localhost:8080/zyhtweb/html/head.html',
            controller:'headController'
        })
        .state('carouse',{
            url:'/carouse',
            templateUrl:'http://localhost:8080/zyhtweb/html/carousel.html'
        })
        .state('footer',{
            url:'/footer',
            templateUrl:'http://localhost:8080/zyhtweb/html/footer.html'
        })
});
app.controller('headController',function($scope,$http){
    $http({
        method: 'post',
        url: '/zyhtweb/action/angular!findAllCustomer.do'
    }).then(function successCallBack(response){
        $scope.customers = response.data;
    },function errorCallBack(response){
        alert("错误");
    })
});


