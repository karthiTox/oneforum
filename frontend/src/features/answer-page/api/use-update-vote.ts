import { useDispatch, useSelector } from "react-redux";
import { useAuth } from "src/features/auth";
import { Answer, UUID, Vote } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { ReduxRootState } from "src/features/redux";
import { setAnswers } from "../question-state-slice";

export function useUpdateVote() {
  const auth = useAuth();
  const axios = useAxios({ authorizedRequest: true });

  const dispatch = useDispatch();

  const question = useSelector(
    (state: ReduxRootState) => state.questionState.question
  );
  const answers = useSelector(
    (state: ReduxRootState) => state.questionState.answers
  );

  const postVote = async (aid: UUID) => {
    if (!auth.isAuth()) return;

    try {
      const response = await axios.post(`/vote/answer/${aid}`);

      const newAnswers = JSON.parse(JSON.stringify(answers)) as Answer[];
      const curAnswerIndex = newAnswers.findIndex((a) => a.aid == aid);
      const curVoteIndex = newAnswers[curAnswerIndex].votes.findIndex(
        (v) => v.voter.uid == auth.currentAuthData.user.uid
      );
      if (curVoteIndex == -1) {
        newAnswers[curAnswerIndex].votes.push(response.data as Vote);
      }
      dispatch(setAnswers(newAnswers));
    } catch {}
  };

  const deleteVote = async (aid: UUID) => {
    if (!auth.isAuth()) return;

    try {
      await axios.delete(`/vote/answer/${aid}`);

      const newAnswers = JSON.parse(JSON.stringify(answers)) as Answer[];
      const curAnswerIndex = newAnswers.findIndex((a) => a.aid == aid);
      const curVoteIndex = newAnswers[curAnswerIndex].votes.findIndex(
        (v) => v.voter.uid == auth.currentAuthData.user.uid
      );
      if (curVoteIndex != -1) {
        newAnswers[curAnswerIndex].votes.splice(curVoteIndex, 1);
      }
      dispatch(setAnswers(newAnswers));
    } catch {}
  };

  return {
    postVote,
    deleteVote,
  };
}
