var werewolvesObject = (function () {
    var getTotalPlayers = function () {
        return $("#people").val();
    };

    var getTotalWerewolves = function () {
        return $("#werewolf").val();
    };

    var getTotalCheckedGods = function () {
        return $("input").filter(function (i, ele) {
            return "checkbox" == ele.type && ele.checked
        });
    };

    var countVillager = function () {
        var villagers = getTotalPlayers() - getTotalCheckedGods().length - getTotalWerewolves();
        if (villagers < 0) {
            alert("平民数少于0，请增加总人数");
            event.preventDefault();
        }
        $("#villager").val(villagers < 0 ? 0 : villagers);
        return villagers;
    };

    var getAllRoles = function () {
        var roles = [];
        if (countVillager() >= 0) {
            for (var i = 0; i < $("#werewolf").val(); i++) {
                roles.push("1");
            }
            for (var i = 0; i < $("#villager").val(); i++) {
                roles.push("5");
            }
            getTotalCheckedGods().each(function (i, ele) {
                roles.push(ele.value);
            });
        }
        return roles;
    };

    var creategame = function () {
        var roles = getAllRoles();
        if (roles.length > 0) {
            $.ajax({
                url: 'http://192.168.1.102:8000/werewolvesGames',
                method: "POST",
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify({roles: roles}),
                async: false,
                success: function (res) {
                    window.location.href = window.location.href.split("/were.html")[0] + "/succeed.html?create&" + res;
                }
            });
        }
    };

    return {
        countVillager: countVillager,
        creategame: creategame
    };
})();

(function m1() {
    $("input").filter(function (i, ele) {
        return "checkbox" == ele.type
    }).each(function (i, ele) {
        $(ele).on("click", werewolvesObject.countVillager)
    });
})();