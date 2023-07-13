import { PAGINATION_FETCH_SIZE } from "src/config";
import { Topic } from "src/features/data/topic";
import { useAxios } from "src/features/lib/use-axios";
import usePagination from "../use-pagination";
import TopicCard from "./topic-card";

export function PaginatedTopicList() {
  const axios = useAxios();

  const fetchData = async (pageNo: number) => {
    const path = `/topic/page/${pageNo}/size/${PAGINATION_FETCH_SIZE}`;

    try {
      const response = await axios.get(path);
      return response.data as Topic[];
    } catch {
      return [];
    }
  };

  const { items: paginatedTopics, loadNextPage } = usePagination<Topic, string>(
    {
      fetchData,
      watchedValues: [],
    }
  );

  return (
    <>
      <div className="list-group">
        {paginatedTopics.map((t, i) => (
          <TopicCard key={i} topic={t} />
        ))}

        {paginatedTopics.length == 0 && (
          <p className="text-center py-3">
            No new topics created yet!         
          </p>
        )}

        <button
          className={`list-group-item list-group-item-action fs-6 text-center`}
          onClick={() => loadNextPage()}
        >
          Load more
        </button>
      </div>
    </>
  );
}
