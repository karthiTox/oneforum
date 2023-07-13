import { NavBar } from "src/features/nav-bar";
import { PaginatedTopicList } from "src/features/paginated-list";
import { AppContainer, SpacingBox } from "src/features/ui";

export default function AllTopic() {
  return (
    <>
      <NavBar currentPage="all-topic"/>
      <SpacingBox/>
      <AppContainer>        
        <p className="p-0 m-0 mb-3 fs-5 fw-bold">All Topics</p>
        <PaginatedTopicList />
      </AppContainer>
    </>
  );
}