import { PAGINATION_FETCH_SIZE } from "src/config";
import { Question, UUID } from "src/features/data";
import { Topic } from "src/features/data/topic";
import { useAxios } from "src/features/lib/use-axios";
import { QuestionCard } from "../question-card";
import usePagination from "../use-pagination";

interface Props {
  uid: UUID;
}

export function PaginatedUserQuestionList({ uid }: Props) {
  const axios = useAxios();

  const fetchData = async (pageNo: number) => {
    const path = `/question/user/${uid}/page/${pageNo}/size/${PAGINATION_FETCH_SIZE}`;

    try {
      const response = await axios.get(path);
      return response.data as Question[];
    } catch {
      return [];
    }
  };

  const { items: questions, loadNextPage } = usePagination<Question, string>({
    fetchData,
    watchedValues: [uid],
  });

  return (
    <>
      {questions.map((q, i) => (
        <QuestionCard key={i} question={q} />
      ))}

      <button
        className="btn btn-dark rounded-pill px-3 mt-3 d-block" style={{marginLeft: "auto", marginRight: "auto"}}
        onClick={() => loadNextPage()}
      >
        Load more
      </button>
    </>
  );
}
