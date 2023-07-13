import { configureStore } from '@reduxjs/toolkit'
import { loadFromLocalStorage, saveToLocalStorage } from './local-storage';

import { authSliceReducer } from "../auth"
import { questionStateSliceReducer } from '../answer-page/question-state-slice';

export const store = configureStore({
  reducer: {
    auth: authSliceReducer,
    questionState: questionStateSliceReducer
  },
  preloadedState: loadFromLocalStorage(),

})

store.subscribe(() => saveToLocalStorage(store.getState()));

export type ReduxRootState = ReturnType<typeof store.getState>