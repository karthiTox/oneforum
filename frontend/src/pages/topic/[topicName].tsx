import { useParams } from "react-router";
import { NavBar } from "src/features/nav-bar";
import { PaginatedQuestionList } from "src/features/paginated-list";
import { AppContainer, SpacingBox } from "src/features/ui";

export function TopicQuestionPage() {
  const { topicName } = useParams();

  return (
    <>
      <NavBar currentPage={topicName ?? "All"} />
      <SpacingBox />
      <AppContainer>
        <p className="p-0 mb-5 fs-2 fw-bold"># {topicName ?? "All"}</p>
        <PaginatedQuestionList topicName={topicName ?? ""} />
      </AppContainer>
    </>
  );
}
