import { useDispatch, useSelector } from "react-redux";
import { Answer, UUID } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { ReduxRootState } from "src/features/redux";
import { setAnswers } from "../question-state-slice";

export function useDeleteAnswer() {
  const axios = useAxios({ authorizedRequest: true });
  const dispatch = useDispatch();

  const question = useSelector(
    (state: ReduxRootState) => state.questionState.question
  );
  const answers = useSelector(
    (state: ReduxRootState) => state.questionState.answers
  );

  const deleteAnswer = async (aid: UUID) => {
    try {
      await axios.delete(`/answer/${aid}`);

      const newAnswers = JSON.parse(JSON.stringify(answers)) as Answer[];
      const curAnswerIndex = newAnswers.findIndex((a) => a.aid == aid);
      if(curAnswerIndex != -1) {
        newAnswers.splice(curAnswerIndex, 1);
      }
      dispatch(setAnswers(newAnswers));      
    } catch {
      return null;
    }
  };

  return {
    answers,
    deleteAnswer
  };
}
