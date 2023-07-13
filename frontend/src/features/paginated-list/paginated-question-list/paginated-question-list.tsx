import { Link } from "react-router-dom";
import { PAGINATION_FETCH_SIZE } from "src/config";
import { Question } from "src/features/data";
import { useAxios } from "src/features/lib/use-axios";
import { QuestionCard } from "../question-card";
import usePagination from "../use-pagination";

interface Props {
  topicName: string;
}

export function PaginatedQuestionList({ topicName }: Props) {
  const axios = useAxios();

  const fetchData = async (pageNo: number) => {
    const path =
      topicName === ""
        ? `/question/page/${pageNo}/size/${PAGINATION_FETCH_SIZE}`
        : `/question/topic/${topicName}/page/${pageNo}/size/${PAGINATION_FETCH_SIZE}`;

    try {
      const response = await axios.get(path);
      return response.data as Question[];
    } catch {
      return [];
    }
  };

  const { items: questions, loadNextPage } = usePagination<Question, string>({
    fetchData,
    watchedValues: [topicName],
  });

  return (
    <>
      {questions.map((q, i) => (
        <QuestionCard key={i} question={q} />
      ))}

      {questions.length == 0 && (
        <p className="text-center py-3">
          try adding new questions{" "}
          <Link to={`/post-question`} className="text-dark">
            add question
          </Link>
        </p>
      )}

      <button
        className="btn btn-outline-dark rounded-pill px-3 mt-3 d-block"
        style={{ marginLeft: "auto", marginRight: "auto" }}
        onClick={() => loadNextPage()}
      >
        Load more
      </button>
    </>
  );
}
