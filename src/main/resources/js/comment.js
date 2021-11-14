$(function (){
    const appendComment = function (data) {
        var commentCode = '<h4>' + data.name + '</h4>>';
        $('#book-list').append('<div>' + commentCode + '</div>');
    };

    //Loading comments on load page
    $.get('/comments/', function (response) {
        for(i in response) {
            appendComment(response[i]);
        }
    });

    //Adding comment
    $('#save-comment').click(function ()
    {
        var data = $('#container').serialize();
        $.ajax({
            method: "POST",
            url: '/comments/',
            data: data,
            success: function (response)
            {
                $('save-comment').css('display', 'none');
                var comment = {};
                comment.id = response.id;
                var dataArray = $('#container form').serializeArray();
                for (i in dataArray) {
                    comment[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendComment(comment);
            }
        });
        return false;
    });
});



