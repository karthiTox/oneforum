import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Question } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { ReduxRootState } from "src/features/redux";
import { setQuestion } from "../question-state-slice";

export function useGetQuestion(qid: string) {
  const axios = useAxios();
  const dispatch = useDispatch();

  const question = useSelector(
    (state: ReduxRootState) => state.questionState.question
  );

  const fetchQuestion = async () => {
    try {
      const response = await axios.get(`/question/${qid}`);
      dispatch(setQuestion(response.data as Question));
    } catch {}
  };

  return {
    question,
    fetchQuestion,
  };
}
