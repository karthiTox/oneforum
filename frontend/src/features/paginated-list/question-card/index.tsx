import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "src/features/auth";
import { Question } from "src/features/data";
import { ProfileIcon } from "src/features/ui";
import { formatRelativeTime } from "src/features/utils";
import styles from "./question-card.module.css";

interface Props {
  question: Question;
}

export function QuestionCard({ question }: Props) {
  const auth = useAuth();
  const naviagte = useNavigate();

  const InfoSection = () => (
    <div className="d-flex flex-wrap gap-1 align-items-center">
      <ProfileIcon
        onClick={() => naviagte(`/profile/${question.owner.uid}`)}
        size="30px"
        fontSize="15px"
        username={question.owner.name}
      />
      <Link
        to={`/profile/${question.owner.uid}`}
        className="text-decoration-none text-capitalize fst-italic text-secondary"
        style={{ fontSize: "1rem" }}
      >
        {question.owner.name}
      </Link>
      <span>in</span>
      <Link
        to={`/topic/${question.topic.topicName}`}
        className="text-decoration-none text-capitalize fst-italic text-secondary"
        style={{ fontSize: "1rem" }}
      >
        {question.topic.topicName}
      </Link>
      <span>·</span>
      <span className="fs-6 text-secondary">
        {formatRelativeTime(new Date(question.createdAt))}
      </span>
      {question.owner.uid === auth.currentAuthData.user.uid && (
        <span className="badge text-white bg-warning rounded-pill ms-2">
          Your Question
        </span>
      )}
    </div>
  );

  return (
    <div className="row justify-content-between w-100 pb-4 mb-4">
      <div className="col-md-8 col-12 d-flex flex-column align-items-start gap-3">
        <InfoSection />

        <Link
          to={`/question/${question.qid}`}
          className={`${styles.changeBlueColorOnHover} fs-5 p-0 m-0 fw-bold`}
        >
          {question.content}
        </Link>

        <Link
          to={`/topic/${question.topic.topicName}`}
          className="badge rounded-pill text-secondary bg-light text-decoration-none"
          style={{ fontSize: "1rem" }}
        >
          {question.topic.topicName}
        </Link>
      </div>
      <div className="col-auto">
        <div>
          <Link
            to={`/question/${question.qid}`}
            className="btn btn-primary btn-sm rounded-pill fw-bold"
          >
            {question.totalAnswers} Answers
          </Link>
        </div>
      </div>
    </div>
  );
}
