import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { ReduxRootState } from "src/features/redux";
import { extractProfileText } from "src/features/utils";

export function SideBar() {
  const question = useSelector(
    (state: ReduxRootState) => state.questionState.question
  );
  const answers = useSelector(
    (state: ReduxRootState) => state.questionState.answers
  );

  return (
    <div className="d-flex flex-column">
      <div
        className="d-flex justify-content-center align-items-center rounded bg-dark text-white fs-1 my-3"
        style={{ width: "150px", height: "150px" }}
      >
        {extractProfileText(question?.owner.name ?? "Aa")}
      </div>

      <h1 className="fs-1 fw-bold mb-4">{question?.owner.name}</h1>
      <p className="p-0 m-0 mb-3 fs-5 fw-bold">Topic</p>
      <div className="list-group w-100 mb-3">
        <Link
          to={`/topic/${question?.topic.topicName}`}
          className="list-group-item list-group-item-action"
        >
          {question?.topic.topicName}
        </Link>
      </div>

      {answers.length > 0 && <p className="p-0 m-0 mb-3 fs-5 fw-bold">Participants</p>}
      <div className="list-group w-100">
        {answers
          .map((a) => a.owner.name + "!@!" + a.owner.uid)
          .filter((item, pos, arr) => {
            return arr.indexOf(item) == pos;
          })
          .sort()
          .map((p, i) => {
            const username = p.split("!@!")[0];
            const uid = p.split("!@!")[1];
            return (
              <Link
                key={i}
                to={`/profile/${uid}`}
                className="list-group-item list-group-item-action"
              >
                {username}
              </Link>
            );
          })}
      </div>
    </div>
  );
}
