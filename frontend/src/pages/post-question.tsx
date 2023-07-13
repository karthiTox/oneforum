import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { useAuth } from "src/features/auth";
import { useAxios } from "src/features/lib/use-axios";
import { NavBar } from "src/features/nav-bar";
import { AppContainer, ProfileIcon, SpacingBox } from "src/features/ui";

export function PostQuestion() {
  // redirects to LOGIN page, if not authorized
  const navigate = useNavigate();
  const auth = useAuth();
  useEffect(() => {
    if (!auth.isAuth()) {
      navigate("/login", {
        replace: true,
      });
    }
  }, []);

  // upload question logic
  const [questionContent, setQuestionContent] = useState("");
  const [topicName, setTopicName] = useState("");
  const [error, setError] = useState("");
  const axios = useAxios({
    authorizedRequest: true,
  });

  const postQuestion = async () => {
    setError("");

    if (questionContent == "") {
      setError("question body should not be empty");
      return;
    }

    if (topicName == "") {
      setError("topic should not empty");
      return;
    }

    try {
      const response = await axios.post("/question", {
        content: questionContent,
        topicName,
      });
      navigate(`/question/${response.data.qid}`);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      <NavBar currentPage="post-question" />
      <SpacingBox />
      <AppContainer centerContent={true}>
        <form
          onSubmit={(e) => {
            e.preventDefault();
            postQuestion();
          }}
          className="w-100 d-flex flex-column align-items-start justify-content-start gap-3 "
          style={{
            maxWidth: "640px",
          }}
        >
          <div className="d-flex flex-wrap gap-2 align-items-center">
            <ProfileIcon
              size="30px"
              fontSize="15px"
              username={auth.currentAuthData.user.name}
            />
            <p className="fs-6 p-0 m-0">
              <span className="fw-bold">{auth.currentAuthData.user.name}</span>
              <span>, it will be posted publicly on oneforum</span>
            </p>
          </div>

          <div className="w-100">
            <textarea
              className="form-control w-100 mb-2"
              rows={7}
              maxLength={255}
              id="content"
              placeholder="What's your question?"
              onChange={(e) => setQuestionContent(e.target.value)}
            />

            <input
              type="text"
              className="form-control w-100"
              id="topic"
              pattern="^\b[a-zA-Z0-9_]+\b$"
              placeholder="Topic?"
              onChange={(e) => setTopicName(e.target.value)}
            />
          </div>

          {error && (
            <p className="fs-6 p-0 m-0 text-danger text-center">{error}</p>
          )}

          <div className="d-flex flex-wrap gap-2">
            <button type="submit" className="btn btn-dark text-white" 
              // style={{borderColor: "#dae7ff", backgroundColor: "#9eb1ff"}} 
              >
              Post Question
            </button>
            <button
              className="btn btn-outline-secondary"  
              onClick={() => navigate(-1)}
            >
              Cancel
            </button>
          </div>
        </form>
      </AppContainer>
    </>
  );
}
