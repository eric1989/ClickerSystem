var questionNumber = {  value : 0,
                        getNumber:function(){this.value++; return this.value;}
                     };

clickerSystem.controller('signInController', function ($scope,$location,$http, $cookieStore) {
      var userName;
      var userPass;
      var userStatus;
      // $scope.changeStatus = function (status) {
      //   userStatus = status;
      //   $cookieStore.put("userStatus",userStatus);
      // };
      $scope.status = true;
      $scope.$watch(function(){return $scope.status;}, function(status){
          userStatus = status;
          console.log(status);
          if (status) {
            userStatus = "student";
          }
          else {
            userStatus = "instructor";
          }
          $cookieStore.put("userStatus",userStatus);
        } 
      );
      $scope.submit = function() {
      	userName = $scope.userName;
      	userPass = $scope.userPass;
        var input ="/" + userStatus + "/login?Name=" + userName + "&Password=" + userPass;
      	$http.post(input).success(function(response){
          console.log(response.toString());
          if (userStatus == "student") {
            if (response.toString() != "-1") {
                $location.path('/session');
                $cookieStore.put("Id",response.toString());
            }
            else {
                $location.path('/signIn');
                $scope.showSuccessAlert = true;
            }
          }
          else {
            if (response.toString() != "-1") {
                $location.path('/session');
                $cookieStore.put("Id",response.toString());
            }
            else {
                $location.path('/signIn');
                $scope.showSuccessAlert = true;
            }
          }
      	});
      };
});

clickerSystem.controller('questionController', function ($scope,$http,$cookieStore) {
	$scope.answer = "You choose:"
	var choose = null;
	$scope.choice = function(answer){
		choose = answer;
		$scope.answer = "You choose: " + choose;
	};

	$scope.submitAnswer = function(){
      var url = "/studentSubmit/submit?";
      var input = url + "studentId=" + $cookieStore.get("Id") + "&" + "answer=" + choose + "&" + "classId=" + $cookieStore.get("classId");
      $http.post(input).
            success(function(data) {
                  $scope.answer = data.toString();
            });
	};
});

clickerSystem.controller('summaryController', function ($scope,$http,$location,$cookieStore) {

  $scope.back = function() {
    $location.path('/teacherSet');
  };

  var url = "/getAnalysis?classId=" + $cookieStore.get("classId");
  $http.get(url).
        success(function (data){
           console.log(data);
           $scope.doughnutData = [
                     {label : $cookieStore.get("correctAnswer"), labelFontSize : 45, labelColor : "#FF0000"},
                     {label : data[0].answer, labelColor : "#FFFFFF", value : data[0].percentage, color : "#F7464A"},
                     {label : data[1].answer, labelColor : "#FFFFFF", value : data[1].percentage, color : "#E2EAE9"},
                     {label : data[2].answer, labelColor : "#FFFFFF", value : data[2].percentage, color : "#D4CCC5"},
                     {label : data[3].answer, labelColor : "#FFFFFF", value : data[3].percentage, color : "#949FB1"}
                   ];
        });
});

clickerSystem.controller('sessionController', function ($scope,$location,$http,$cookieStore) {

    var url = "/class/getClassesById?" + "Id=" + $cookieStore.get("Id") + "&caller=" + $cookieStore.get("userStatus");
    $http.get(url).
        success(function (data) {
            $scope.classes = data;
        });

    $scope.changeSession = function(classId){
      // need to handle classId so that classId could be used when student answer the question
      $cookieStore.put("classId",classId);
      var status = $cookieStore.get("userStatus");
      if (status == "student") {
          $location.path('/question');
      }
      else if (status == 'instructor') {
          $location.path('/teacherSet');
      }
    }
});

clickerSystem.controller('teacherSetController',function($scope,$http,$location,$cookieStore) {
    $scope.questionNumber = questionNumber.getNumber();
    $scope.success = false;
    $scope.submit = function () {
        var url = "/teacherSet?" + "classId=" + $cookieStore.get("classId") + "&number=" + $scope.questionNumber + "&answer=" + $scope.answer;
        $http.post(url).
            success(function(data){
                 $cookieStore.put("correctAnswer",$scope.answer);
                 if(data.toString()=="success") {
                    $scope.success = true;
                 }
            });
    };
    $scope.setAnswer = function(answer){
        $scope.answer = answer;
    };

    $scope.viewSummary = function(){
        $location.path('/summary');
    };
});

