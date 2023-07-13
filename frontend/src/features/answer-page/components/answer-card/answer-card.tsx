import { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";
import { useAuth } from "src/features/auth";
import { Answer } from "src/features/data";
import { formatRelativeTime } from "src/features/utils";
import { useDeleteAnswer, useUpdateVote } from "../..";
import { ArrowUpIcon } from "./arrow-up-icon";

interface Props {
  answer: Answer;
}

export function AnswerCard({ answer }: Props) {
  const auth = useAuth();

  const isVoted = () => {
    if (!auth.isAuth()) return false;

    for (let i = 0; i < answer.votes.length; i++) {
      const vote = answer.votes[i];
      if (vote.voter.uid == auth.currentAuthData.user.uid) {
        return true;
      }
    }

    return false;
  };

  const { postVote, deleteVote } = useUpdateVote();
  const { deleteAnswer } = useDeleteAnswer();

  return (
    <div className="fs-6 w-100 my-3 py-3 rounded d-flex flex-column align-items-start">
      <div className="d-flex align-items-center gap-2 mb-2">
        <p
          className="m-0 p-0 fw-bold text-secondary text-capitalize"
          style={{ fontSize: "0.9rem" }}
        >
          <Link
            to={`/profile/${answer.owner.uid}`}
            className="text-decoration-none text-secondary text-capitalize fst-italic fs-6"
            style={{ fontSize: "1rem" }}
          >
            {answer.owner.name}
          </Link>
          <span className="mx-1">-</span>
          {formatRelativeTime(new Date(answer.createdAt ?? ""))}
          {/* <Link to={``} className="m-0 p-0 text-dark ms-1" onClick={()=>{}}>Edit</Link> */}
          {/* {answer.owner.uid == auth.currentUser.user.uid && <span className="badge text-white bg-warning rounded-pill ms-2">
            Your Answer
          </span>} */}
          {answer.owner.uid == auth.currentAuthData.user.uid && (
            <>
              <button
                className="badge text-dark bg-white border rounded-pill ms-2"
                type="button"
                id="EditdropdownMenuButton"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Edit
              </button>

              <ul
                className="dropdown-menu"
                aria-labelledby="EditdropdownMenuButton"
              >
                <li>
                  <Link
                    className="dropdown-item"
                    to={`/profile/${answer.owner.uid}`}
                  >
                    View Profile
                  </Link>
                </li>
                <li>
                  <a
                    className="dropdown-item text-danger"
                    type="button"
                    onClick={() => deleteAnswer(answer.aid)}
                  >
                    Delete Answer
                  </a>
                </li>
              </ul>
            </>
          )}

          {answer.owner.uid == auth.currentAuthData.user.uid && (
            <span className="badge text-white bg-warning rounded-pill ms-2">
              Your Answer
            </span>
          )}
        </p>
      </div>

      <p className="m-0 p-0 mb-3 fs-5">{answer.content}</p>

      <button
        className={`btn ${
          isVoted() ? "btn-primary" : "btn-dark"
        } d-flex align-items-center rounded-pill ps-1`}
        onClick={() => {
          if (isVoted()) {
            deleteVote(answer.aid);
          } else {
            postVote(answer.aid);
          }
        }}
      >
        <ArrowUpIcon />
        <p className="d-inline p-0 m-0" style={{ fontSize: "12px" }}>
          {answer.votes.length}
        </p>
      </button>
    </div>
  );
}
