import { useState } from "react";
import { Link } from "react-router-dom";
import { useAuth } from "src/features/auth";
import { usePostAnswer } from "../api";

export default function PostAnswerSection() {
  const auth = useAuth();

  const { answers, postAnswer } = usePostAnswer();

  const [answerContent, setAnswerContent] = useState("");

  return (
    <>
      {!auth.isAuth() && (
        <p className="border border-1 border-dark px-1 py-4 rounded text-dark text-center mt-3">
          <Link to={`/register`} className="text-dark fw-bold">
            Register
          </Link>
          <span>
            {" "}
            to join this conversation on oneForum. Already have an account?
          </span>

          <Link to={`/login`} className="text-dark fw-bold ms-1">
            Login
          </Link>
        </p>
      )}
      {auth.isAuth() && (
        <form
          onSubmit={(e) => {
            e.preventDefault();
            postAnswer(answerContent);
            setAnswerContent("");
          }}
          className="text-center text-center d-flex flex-column justify-content-start align-items-start gap-3 mt-3"
        >
          <textarea
            className="form-control rounded fs-5"
            rows={5}
            id="content"
            placeholder="Be sepcific ..."
            maxLength={255}
            value={answerContent}
            onChange={(e) => setAnswerContent(e.target.value)}            
          />

          <button type="submit" className="btn btn-dark px-3">
            Post Answer
          </button>
        </form>
      )}
    </>
  );
}
