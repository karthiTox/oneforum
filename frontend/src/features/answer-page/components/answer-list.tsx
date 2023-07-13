import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { Answer } from "src/features/data";
import { AnswerCard } from "./answer-card/answer-card";

interface Props {
  answers: Answer[];
}

export function AnswerList({ answers }: Props) {
  return (
    <>
      {answers?.map((a, i) => {
        return <AnswerCard key={i} answer={a} />;
      })}
    </>
  );
}
