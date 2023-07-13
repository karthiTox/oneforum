import { useDispatch, useSelector } from "react-redux";
import { ReduxRootState } from "src/features/redux";
import { setAuthData } from ".";
import { AuthData } from "src/features/data";

export function useAuth() {
  const currentAuthData = useSelector((state: ReduxRootState) => state.auth);
  const dispatch = useDispatch();

  const isAuth = () => {
    return currentAuthData.token != "";
  };

  const logout = () => {
    dispatch(
      setAuthData({
        user: {
          uid: "",
          name: "",
          email: "",
          role: "",
        },
        token: "",
      })
    );
  };

  const login = (authData: AuthData) => {
    console.log("currentAuthUser", authData)
    dispatch(
      setAuthData(authData)
    );
  };

  return {
    currentAuthData,
    isAuth,
    login,
    logout,
  }
}
