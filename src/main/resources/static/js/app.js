/**
 * Created by Administrator on 2017/4/21.
 */
var flashingBuy = angular.module('flashingBuyApp',['ui.router', 'common.flashingBuy.httpService'])
    .config(function ($routeProvider, $locationProvider, $httpProvider) {

     $locationProvider.html5Mode(true);
    var version = new Date().getTime();

    $routeProvider.when('/', {
        title : '首页',
        templateUrl : '/static/html/test.html?v=' + version,
        controller : 'testController'
    }).when('/index', {
        title : '首页',
        templateUrl : '/static/html/test.html?v=' + version,
        controller : 'testController'
    }).otherwise({
        redirectTo: '/'
    });

    // http拦截
    $httpProvider.responseInterceptors.push(function ($q) {
        return function (promise) {
            return promise.then(function (response) { // success
                return response;
            }, function (response) { // fail
                // http状态码400
                if (response.status == 401) {
                    if (response.data && response.data.message) {
                        window.location.href = '/NoPrivilege';
                    }
                }
                return $q.reject(response);
            });
        }
    });
}).run(function ($rootScope, httpService) {
    //设置页面标题
    $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
        $rootScope.title = current.$$route.title;
    });

});