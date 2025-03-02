package com.GlobeTrotter.DTO;

public class AnswerRequestDTO {
    private Long questionId;
    private Long selectedOptionId;
    private Long userId;

    public AnswerRequestDTO() {
    }

    public AnswerRequestDTO(Long questionId, Long userId, Long selectedOptionId) {
        this.questionId = questionId;
        this.userId = userId;
        this.selectedOptionId = selectedOptionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSelectedOptionId() {
        return selectedOptionId;
    }

    public void setSelectedOptionId(Long selectedOptionId) {
        this.selectedOptionId = selectedOptionId;
    }
}
