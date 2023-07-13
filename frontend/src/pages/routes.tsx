import { createBrowserRouter, useRoutes } from "react-router-dom";
import AllTopic from "./all-topic";
import { Home } from "./home";

import { Login } from "./login";
import { PostQuestion } from "./post-question";
import {ProfilePage} from "./profile/[uid]";
import { QuestionView } from "./question/[qid]";
import { Register } from "./register";
import {TopicQuestionPage} from "./topic/[topicName]";

const routes = createBrowserRouter([
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/register",
    element: <Register />,
  },
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/topic/:topicName",
    element: <TopicQuestionPage />,
  },
  {
    path: "/profile/:uid",
    element: <ProfilePage />,
  },
  {
    path: "/all-topic",
    element: <AllTopic />,
  },
  {
    path: "/post-question",
    element: <PostQuestion />,
  },
  {
    path: "/question/:qid",
    element: <QuestionView />,
  },
  
]);

export default routes;
