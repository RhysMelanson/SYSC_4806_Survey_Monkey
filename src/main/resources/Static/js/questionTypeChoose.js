var QuestionTypeChoose = {
    setup: function() {
        QuestionTypeChoose.hideChoices();
        $(document).on('change', '#radioClicked', QuestionTypeChoose.showChoice);
        $(document).on('reset', 'form', QuestionTypeChoose.hideChoices);
    },
    showChoice() {
        var multipleChoice = $('#multiple-choice');
        var numberRange = $('#number-range');
        if($('#radioButtonSelectedValue2').is(':checked')) {
            numberRange.hide();
            multipleChoice.show();
        }else if($('#radioButtonSelectedValue3').is(':checked')) {
            multipleChoice.hide();
            numberRange.show();
        }else{
            multipleChoice.hide();
            numberRange.hide();
        }
        return false;
    },
    hideChoices() {
        $('#multiple-choice').hide();
        $('#number-range').hide();
    }
};
$(QuestionTypeChoose.setup);