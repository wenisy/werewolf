var dispatcherRole = (function () {
    var dispatch = function (role) {
        return parseRole(role);
    };

    var parseRole = function (role) {
        var roleName = "";
        switch (role) {
            case 1 :
                roleName = "狼人";
                break;
            case 2 :
                roleName = "预言家";
                break;
            case 3 :
                roleName = "猎人";
                break;
            case 4 :
                roleName = "女巫";
                break;
            case 5 :
                roleName = "村民";
                break;
            case 6 :
                roleName = "白痴";
                break;
            case 7 :
                roleName = "丘比特";
                break;
            case 8 :
                roleName = "白狼王";
                break;
            case 9 :
                roleName = "守卫";
                break;
            case 10 :
                roleName = "隐狼";
                break;
            case 11 :
                roleName = "野孩子";
                break;
            default:
                document.getElementById("titleName").innerHTML = "";
                roleName = "房间人数已满";
                break;
        }
        return roleName;
    };
    return {
        dispatch: dispatch
    };
})();

(function () {
    //?fromWhere&roomNumber
    var fromWhere = location.search.split("?")[1].split("&")[0];
    var roomNumber = location.search.split("&")[1];
    if ("getRole" == fromWhere) {
        document.getElementById("titleName").innerHTML = "您的角色是:";
        $.ajax({
            url: 'http://localhost:8000/werewolvesGames',
            method: "GET",
            contentType: "application/json;charset=UTF-8",
            data: {Id: roomNumber},
            async: false,
            success: function (res) {
                document.getElementById("roomOrRole").innerHTML = dispatcherRole.dispatch(res);
            }
        });
    } else {
        document.getElementById("roomOrRole").innerHTML = roomNumber;
    }
})();