$(document).ready(function () {
    $.ajax({
        url: 'api/v1/extension/all',
        type: 'GET',
        success: function (data) {
            data.forEach(function (res) {
                $('input[value="' + res.extensionName + '"]').prop('checked', true);
            });
        }
    });
});

$(document).ready(function () {
    $('.check').change(function () {
        let fixedExtensionValue = $(this).val();
        let isChecked = $(this).is(':checked');

        if (isChecked) {
            $.ajax({
                url: '/api/v1/extension',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({extensionName : fixedExtensionValue}),
                success: function (res) {
                    alert(res.extensionName + "확장자가 추가되었습니다.");
                },
                error: function (error) {
                    alert(error.responseText);
                }
            });
        } else {
            $.ajax({
                url: 'api/v1/extension/delete',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify({extensionName : fixedExtensionValue}),
                success: function (res) {
                    alert(res.extensionName + "확장자가 삭제되었습니다.");
                },
                error: function (error) {
                    alert(error.responseText);
                }
            });
        }
    });
});

$(document).ready(function () {
    function refreshExtensionList() {
        $.ajax({
            url: 'api/v1/custom-extension/all',
            type: 'GET',
            success: function (data) {
                let customExtensionCount = data.length;

                $('#customExtensionCount').text(customExtensionCount + "/200");
                data.forEach(function (res) {
                    $('#saveExtension').append(
                        '<div id="extensionItem">' +
                        res.extensionName +
                        ' <button id="deleteButton">X</button></div>'
                    );
                });
            }
        });
    }

    refreshExtensionList();

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
            success: function (res) {
                alert(res.extensionName + " 확장자가 추가되었습니다.");
                refreshExtensionList();
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
            success: function (res) {
                alert(res.extensionName + " 확장자가 삭제되었습니다.");
                document.location.reload();
            },
            error: function (error) {
                alert(error.responseText);
            }
        });
    });
});
