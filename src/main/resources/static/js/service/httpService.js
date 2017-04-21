/**
 * Created by Administrator on 2016/4/25.
 */

(function() {
    angular.module('common.flashingBuy.httpService', []).
        factory("httpService",function($http, $rootScope){
            return {
                get: function (url, params) {
                    $rootScope.isLoading = true;
                    return $http.get(url, {params: params}).success(function (data) {
                        $rootScope.isLoading = false;
                    }).error(function (data) {
                        $rootScope.isLoading = false;
                        if(!data.message){
                            alert("服务器异常");
                        }else if(data.message == '无权限'){
                            return ;
                        }else if(data.message != '无权限'){
                            alert(data.message);
                        }
                    });
                },
                post: function (url, params) {
                    $rootScope.isLoading = true;
                    return $http.post(url, params).success(function (data) {
                        $rootScope.isLoading = false;
                    }).error(function (data) {
                        $rootScope.isLoading = false;
                        if(!data.message){
                            alert("服务器异常");
                        }else if(data.message == '无权限'){
                            return ;
                        }else if(data.message != '无权限'){
                            alert(data.message);
                        }

                    });
                },
                put: function (url, params) {
                    $rootScope.isLoading = true;
                    return $http.put(url, params).success(function (data) {
                        $rootScope.isLoading = false;
                    }).error(function (data) {
                        $rootScope.isLoading = false;
                        if(!data.message){
                            alert("服务器异常");
                        }else if(data.message == '无权限'){
                            return ;
                        }else if(data.message != '无权限'){
                            alert(data.message);
                        }

                    });
                },
                delete: function (url, params) {
                    $rootScope.isLoading = true;
                    return $http.delete(url, params).success(function (data) {
                        $rootScope.isLoading = false;
                    }).error(function (data) {
                        $rootScope.isLoading = false;
                        if(!data.message){
                            alert("服务器异常");
                        }else if(data.message == '无权限'){
                            return ;
                        }else if(data.message != '无权限'){
                            alert(data.message);
                        }
                    });
                }
            }
        });
}());
