import { createSlice } from '@reduxjs/toolkit'
import type { PayloadAction } from '@reduxjs/toolkit'
import { Answer, Question } from '../data';

interface QuestionState {
  question: Question | null;
  answers: Answer[];  
}

export const questionStateSlice = createSlice({
  name: 'questionState',  
  initialState: <QuestionState> {
    question: null,
    answers: []
  },
  reducers: {
    setQuestion: (state, action: PayloadAction<Question>) => {
      state.question = action.payload;      
    },
    setAnswers: (state, action: PayloadAction<Answer[]>) => {
      state.answers = action.payload;      
    },
  },
})

export const { setQuestion, setAnswers } = questionStateSlice.actions
export const  questionStateSliceReducer = questionStateSlice.reducer