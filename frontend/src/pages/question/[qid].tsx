import { useEffect } from "react";
import { useParams } from "react-router";
import {
  AnswerList,
  QuestionSection,
  useGetQuestion,
  useGetAllAnswer,
} from "src/features/answer-page";
import PostAnswerSection from "src/features/answer-page/components/post-answer-section";
import { SideBar } from "src/features/answer-page/components/side-bar";
import { NavBar } from "src/features/nav-bar";
import { AppContainer, SpacingBox } from "src/features/ui";

export function QuestionView() {
  const { qid } = useParams();

  const { question, fetchQuestion } = useGetQuestion(qid ?? "");
  const { answers, fetchAnswers } = useGetAllAnswer(qid ?? "");

  useEffect(() => {
    fetchQuestion();
    fetchAnswers();
  }, []);

  return (
    <>
      <NavBar currentPage="question" />
      <SpacingBox className="my-5" />
      <AppContainer>
        <div className="row g-5">
          <div className="col-md-8 col-12">
            <QuestionSection question={question} />

            <p className="p-0 m-0 fs-5 fw-bold">{answers.length} answers</p>

            <AnswerList answers={answers} />
            <PostAnswerSection />
          </div>
          <div className="col-md-4 col-12 d-md-block d-none">
            <SideBar />
          </div>
        </div>
      </AppContainer>
    </>
  );
}
