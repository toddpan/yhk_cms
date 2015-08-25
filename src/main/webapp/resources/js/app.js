	var usersApp = angular.module('usersApp', []);

usersApp.controller('UserCtrl',['$scope','$http', function($scope, $http){
	$scope.userList = [
	                   {id: 1, name: 'Siva1', email: 'siva1@gmail.com'},
	                   {id: 2, name: 'Siva2', email: 'siva2@gmail.com'},
	                   {id: 3, name: 'Siva3', email: 'siva3@gmail.com'},
	                   {id: 4, name: 'Siva4', email: 'siva4@gmail.com'},
	                   {id: 5, name: 'Siva5', email: 'siva5@gmail.com'}
	                   ];
	$scope.disease = {};

	$scope.diseaseList={}


	$http.post('searchUserExams',{"lastest":true}).success(function(data){
		$scope.userList = data;
	});



	$scope.searchDiseaseExamMapping=function(url){
		var disease=$scope.disease;
		var cloneUser = angular.copy(disease);
		$http.get(url,cloneUser).success(function(data){
			alert(data);
			$scope.diseaseList=data;
		});
	}
	
	$scope.handleEditUser = function(user){
		$scope.editingUser = user;
		var cloneUser = angular.copy(user);//JSON.parse( JSON.stringify( user ) );
		$scope.editUser = cloneUser;
	};
	
	$scope.handleDeleteUser = function(user){
		alert('Delete User: '+user.name);
	};
	
	$scope.handleUpdateUser = function(user){
		alert("xxxxxx")
		//alert('Update User: '+user.name);
		//$scope.editingUser = JSON.parse( JSON.stringify( user ) );
		copy($scope.editingUser, user);
	};
	
	function copy(a, b) {
		  Object.keys(b).forEach(function(key) {
		    a[key] = b[key];
		  });
		}
	
}]);
	function obj2string(o){
		var r=[];
		if(typeof o=="string"){
			return "\""+o.replace(/([\'\"\\])/g,"\\$1").replace(/(\n)/g,"\\n").replace(/(\r)/g,"\\r").replace(/(\t)/g,"\\t")+"\"";
		}
		if(typeof o=="object"){
			if(!o.sort){
				for(var i in o){
					r.push(i+":"+obj2string(o[i]));
				}
				if(!!document.all&&!/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)){
					r.push("toString:"+o.toString.toString());
				}
				r="{"+r.join()+"}";
			}else{
				for(var i=0;i<o.length;i++){
					r.push(obj2string(o[i]))
				}
				r="["+r.join()+"]";
			}
			return r;
		}
		return o.toString();
	}