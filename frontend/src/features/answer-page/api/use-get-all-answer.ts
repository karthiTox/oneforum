import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Answer } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { ReduxRootState } from "src/features/redux";
import { setAnswers } from "../question-state-slice";

export function useGetAllAnswer(qid: string) {
  const axios = useAxios();
  const dispatch = useDispatch();

  const answers = useSelector(
    (state: ReduxRootState) => state.questionState.answers
  );


  const fetchAnswers = async () => {
    try {
      const response = await axios.get(`/answer/${qid}/all`);
      dispatch(setAnswers(response.data as Answer[]));
    } catch {}
  };

  return {
    answers,
    fetchAnswers,
  };
}
