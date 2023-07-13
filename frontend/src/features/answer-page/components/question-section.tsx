import { useAuth } from "src/features/auth";
import { Question } from "src/features/data";
import { formatRelativeTime } from "src/features/utils";

interface Props {
  question: Question | null;
}

export function QuestionSection({ question }: Props) {
  const auth = useAuth();

  return (
    <>
      <p className="fs-6 m-0 p-0">
        <span className="text-capitalize fst-italic">
          {question?.owner.name}
        </span>{" "}
        in <span className="fst-italic">{question?.topic.topicName}</span>
        {" · "}
        <span className="fs-6 text-secondary">
          {formatRelativeTime(new Date(question?.createdAt ?? ""))}
        </span>
        {question?.owner.uid == auth.currentAuthData.user.uid && (
          <span className="badge text-white bg-warning rounded-pill ms-2">
            Your Question
          </span>
        )}
      </p>
      <p className="fs-3 fw-bold mt-2">{question?.content}</p>
    </>
  );
}
