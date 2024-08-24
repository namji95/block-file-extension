$(document).ready(function () {
    $.ajax({
        url: 'api/v1/extension/all',
        type: 'GET',
        success: function (data) {
            data.data.forEach(function (res) {
                $('input[value="' + res.extensionName + '"]').prop('checked', true);
            });
        }
    });
});

$(document).ready(function () {
    $('.check').change(function () {
        let fixedExtensionValue = $(this).val();
        let isChecked = $(this).is(':checked');
        let $this = $(this);

        if (isChecked) {
            $.ajax({
                url: '/api/v1/extension',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({extensionName: fixedExtensionValue}),
                success: function (data) {
                    alert(fixedExtensionValue + " 확장자가 추가되었습니다.");
                },
                error: function (error) {
                    let errorMessage = JSON.parse(error.responseText);
                    alert(errorMessage.message);
                    $this.prop('checked', false);
                }
            });
        } else {
            $.ajax({
                url: 'api/v1/extension/delete',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify({extensionName: fixedExtensionValue}),
                success: function () {
                    alert(fixedExtensionValue + " 확장자가 삭제되었습니다.");
                },
                error: function (error) {
                    let errorMessage = JSON.parse(error.responseText);
                    alert(errorMessage.message);
                }
            });
        }
    });
});

$(document).ready(function () {
    $.ajax({
        url: 'api/v1/custom-extension/all',
        type: 'GET',
        success: function (data) {
            let customExtensionCount = data.data.length;

            if (customExtensionCount >= 1) {
                $('#customExtensionCount').text(customExtensionCount + "/200");
                data.data.forEach(function (res) {
                    $('#saveExtension').append(
                        '<div id="extensionItem">' +
                        res.extensionName +
                        ' <button id="deleteButton">X</button></div>'
                    );
                });
            }
        }
    });

    $('#btn').click(function () {
        let customExtensionValue = $('input[type="text"]').val();

        if (customExtensionValue === "") {
            alert("확장자를 입력해주세요");
            return;
        }

        $.ajax({
            url: 'api/v1/custom-extension',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                extensionName: customExtensionValue
            }),
            success: function () {
                alert(customExtensionValue + " 확장자가 추가되었습니다.");
                document.location.reload();
            },
            error: function (error) {
                alert(error.responseText);
            }
        });
    });

    $('#saveExtension').on('click', '#deleteButton', function () {
        let extensionName = $(this).parent().text().replace(" X", "");

        $.ajax({
            url: 'api/v1/custom-extension/delete',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify({
                extensionName: extensionName
            }),
            success: function () {
                alert(extensionName + "확장자가 삭제되었습니다.");
                document.location.reload();
            },
            error: function (error) {
                let errorMessage = JSON.parse(error.responseText);
                alert(errorMessage.message);
            }
        });
    });
});

$(document).ready(function () {
    $('#uploadBtn').click(function () {

        $.ajax({
            url: "api/v1/file",
            type: "POST",
            data: new FormData($('#uploadForm')[0]),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            success: function () {
                alert("파일이 저장되었습니다.");
            },
            error: function (error) {
                let errorMessage = JSON.parse(error.responseText);
                alert(errorMessage.message);
            }
        });
    });
});