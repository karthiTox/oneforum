import { useDispatch, useSelector } from "react-redux";
import { Answer, UUID } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { ReduxRootState } from "src/features/redux";
import { setAnswers } from "../question-state-slice";

export function usePostAnswer() {
  const axios = useAxios({ authorizedRequest: true });
  const dispatch = useDispatch();

  const question = useSelector(
    (state: ReduxRootState) => state.questionState.question
  );
  const answers = useSelector(
    (state: ReduxRootState) => state.questionState.answers
  );

  const postAnswer = async (content: string) => {
    try {
      const response = await axios.post(`/answer`, {
        content: content,
        questionId: question?.qid,
      });
      dispatch(setAnswers([...answers, response.data as Answer]));      
    } catch {
      return null;
    }
  };

  return {
    answers,
    postAnswer
  };
}
