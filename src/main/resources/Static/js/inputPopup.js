var inputPopup = {
    setup: function() {
        $('#submit').hide();
        $(document).on('change', '#radioClicked', inputPopup.showInput);
        $(document).on('submit', 'form', inputPopup.formValidation);
    },showInput() {
        $('#submit').show();
        return false;
    },formValidation() {
        if($("[name='radioButtonSelectedValue']").is(':checked')) {
            $("form").submit();
            return false;
        }
        return false;
    }
};
$(inputPopup.setup);