import { Link } from "react-router-dom";
import { Topic } from "src/features/data/topic";

interface Props {
  topic: Topic;
}

export default function TopicCard({ topic }: Props) {
  return (
    <Link className={`list-group-item list-group-item-action d-flex justify-content-between align-items-center`} to={`/topic/${topic.topicName}`}>
      <span className="fs-5">{topic.topicName}</span>
      <span className="badge bg-primary rounded-pill ms-2">
        {topic.totalQuestions}
      </span>
    </Link>
  );
}
