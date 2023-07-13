import { useSearchParams } from "react-router-dom";
import { NavBar } from "src/features/nav-bar";
import { PaginatedTopicList } from "src/features/paginated-list";
import { PaginatedQuestionList } from "src/features/paginated-list/paginated-question-list/paginated-question-list";
import { AppContainer, SpacingBox } from "src/features/ui";

export function Home() {
  const [searchParams] = useSearchParams();
  const topic = searchParams.get("topic") ?? "";

  return (
    <>
      <NavBar currentPage="home" />
      <SpacingBox />
      <AppContainer>
        <div className="row g-5">
          <div className="col-md-4 col-12 d-lg-block d-none">
            <p className="p-0 m-0 mb-3 fs-5 fw-bold">Popular Topics</p>
            <PaginatedTopicList />
          </div>
          <div className="col-md-8 col-12">
            <p className="p-0 m-0 mb-3 fs-5 fw-bold">All Questions</p>
            <PaginatedQuestionList topicName={topic} />
          </div>
        </div>
      </AppContainer>
    </>
  );
}
