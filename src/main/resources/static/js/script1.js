$(document).ready(function () {
    getAllUsers();
});

function printRoles(roles) {
    var rolesName = '';
    $.each(roles, function (key, value) {
        rolesName += value.name + '  ';
    });
    return rolesName;
}

function getAllUsers() {
    $.ajax({
        url: '/rest/admin/getListUsers',
        type: 'GET',
        dataType: 'json',
        success: function (list) {
            var trHTML = '';
            $.each(list, function (i, item) {
                trHTML += '<tr>' +
                    '<td>' + item.id + '</td>' +
                    '<td>' + item.name + '</td>' +
                    '<td>' + item.login + '</td>' +
                    '<td>' + item.password + '</td>' +
                    '<td>' + item.email + '</td>' +
                    '<td>' + printRoles(item.roles) + '</td>' +
                    '<td>' +
                    '<button onclick="editUser(' + item.id + ')" data-toggle="modal" data-target="#editModal" class="btn btn-primary editModal">Edit</button> ' +
                    '<button onclick="deleteUser(' + item.id + ')" type="button" class="btn btn-primary">Delete</button>' +
                    '</td>' +
                    '</tr>';
            });

            $('tbody').html(trHTML);
        }
    });


}

function addUser() {
    var name = $("#addTab").find("input[name='name']").val();
    var login = $("#addTab").find("input[name='login']").val();
    var password = $("#addTab").find("input[name='password']").val();
    var email = $("#addTab").find("input[name='email']").val();
    if ($('#isAdmin').is(':checked')) {
        var isAdmin = $("#addTab").find("input[name='isAdmin']").val();
    }
    if ($('#isUser').is(':checked')) {
        var isUser = $("#addTab").find("input[name='isUser']").val();
    }

    $.ajax({
        url: '/rest/admin/add',
        type: 'POST',
        dataType: 'json',
        data: {
            name: name,
            login: login,
            password: password,
            email: email,
            isAdmin: isAdmin,
            isUser: isUser
        },
        success: function () {
            $("#addTab").find("input[name='name']").val('');
            $("#addTab").find("input[name='login']").val('');
            $("#addTab").find("input[name='password']").val('');
            $("#addTab").find("input[name='email']").val('');
            $('body input:checkbox').prop('checked', false);
            $('#myTab a[href="#adminTab"]').tab('show');
            getAllUsers();
        }
    });
}

function editUser(id) {
    $.ajax({
        url: '/rest/admin/getUserById/' + id,
        type: 'GET',
        dataType: 'json',
       /* data: {id: id},*/
        success: function (user) {
            var id = user.id;
            var name = user.name;
            var login = user.login;
            var password = user.password;
            var email = user.email;

            $("#editModal").find("input[name='id']").val(id);
            $("#editModal").find("input[name='name']").val(name);
            $("#editModal").find("input[name='login']").val(login);
            $("#editModal").find("input[name='password']").val(password);
            $("#editModal").find("input[name='email']").val(email);
        }
    });
}

function editUserModal() {
    var id = $("#editModal").find("input[name='id']").val();
    var name = $("#editModal").find("input[name='name']").val();
    var login = $("#editModal").find("input[name='login']").val();
    var password = $("#editModal").find("input[name='password']").val();
    var email = $("#editModal").find("input[name='email']").val();
    if ($('#isAdminEdit').is(':checked')) {
        var isAdmin = $("#editModal").find("input[name='isAdmin']").val();
    }
    if ($('#isUserEdit').is(':checked')) {
        var isUser = $("#editModal").find("input[name='isUser']").val();
    }

    $.ajax({
        url: '/rest/admin/update',
        type: 'POST',
        dataType: 'json',
        data: {
            id: id,
            name: name,
            login: login,
            password: password,
            email: email,
            isAdmin: isAdmin,
            isUser: isUser
        },
        success: function () {
            $(".modal").modal('hide');
            $('body input:checkbox').prop('checked', false);
            getAllUsers();
        }
    });
}

function deleteUser(id) {
    $.ajax({
        url: '/rest/admin/delete/' + id ,
        type: 'DELETE',
        dataType: 'json',
       /* data: {id: id},*/
        success: function () {
            getAllUsers();
        }
    });
}




