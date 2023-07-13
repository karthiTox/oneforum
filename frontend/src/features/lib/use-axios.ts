import { useSelector } from "react-redux";
import { axios } from "./axios"
import { ReduxRootState } from "../redux"

interface Props {
    authorizedRequest?: boolean;
}

export function useAxios({
    authorizedRequest
}: Props = { authorizedRequest: false }) {

    const currentUser = useSelector((state: ReduxRootState) => state.auth);   

    if (authorizedRequest && currentUser.token != "") {        
        axios.defaults.headers.common["Authorization"] = `Bearer ${currentUser.token}`
    } else {
        delete axios.defaults.headers.common["Authorization"]
    }

    return axios
}