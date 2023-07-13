import { createSlice } from '@reduxjs/toolkit'
import type { PayloadAction } from '@reduxjs/toolkit'
import { AuthData } from '../data';

export const authSlice = createSlice({
  name: 'auth',
  initialState: <AuthData>{
    user: {
      uid: "",
      name: "",
      email: "",
      role: "",
    },
    token: "",
  },
  reducers: {
    setAuthData: (state, action: PayloadAction<AuthData>) => {
      state = action.payload;
      return state;
    },
  },
})

export const { setAuthData } = authSlice.actions
export const authSliceReducer = authSlice.reducer