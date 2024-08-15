$(document).ready(function () {
    $('.check').change(function (message) {
        let checkValue = $(this).val();
        let isChecked = $(this).is(':checked');

        $.ajax({
            url: '/api/v1/extension',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                extensionName: checkValue,
                bool: isChecked
            }),
            success: function (res) {
                alert(res.extensionName + "확장자가 추가되었습니다.");
            },
            error: function (error) {
                alert(error.responseText);
            }
        });
    });
});

$(document).ready(function () {
    $('#btn').click(function () {
        let customExtensionValue = $('input[type="text"]').val();

        if (customExtensionValue === "") {
            alert("확장자를 입력해주세요");
            return
        }

        $.ajax({
            url: 'api/v1/custom-extension',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                extensionName: customExtensionValue
            }),
            success: function (res) {
                alert(res.extensionName + "확장자가 추가되었습니다.");
            },
            error: function (error) {
                alert(error.responseText);
            }
        })
    })
})

$(document).ready(function () {
    $.ajax({
        url: 'api/v1/custom-extension/all',
        type: 'GET',
        success: function (data) {
            data.forEach(function (res) {
                $('#saveExtension').append(
                    '<div id="ExtensionList">'
                    + res.extensionName
                    + `<button id="reset-button">X</button>` +
                    '</div>'
                );
                // $('#extensionTable tbody').append('<tr><td>' + res.extensionName + '</td></tr>');
            });
        },
        error: function (error) {
            alert(error.responseText);
        }
    });
});