import { useEffect, useRef } from "react";
import useUniqueArrayState from "./use-unique-array-state";

interface PaginationOptions<T, S> {
  fetchData: (pageNo: number) => Promise<T[]>;
  watchedValues?: S[];
  initialPageNo?: number;
}

export function usePagination<T, S>({
  fetchData,
  watchedValues = [],
  initialPageNo = 0,
}: PaginationOptions<T, S>) {
  const [items, addItems, clearAllItems] = useUniqueArrayState<T>();
  const pageNoRef = useRef(initialPageNo);
  const isFetchingRef = useRef(false);
  const fetchDataRef = useRef(fetchData);

  // Load next page of data
  const loadNextPage = async () => {
    if (isFetchingRef.current) return;
    isFetchingRef.current = true;

    const fetchedItems = await fetchDataRef.current(pageNoRef.current);
    if (fetchedItems.length > 0) {
      pageNoRef.current++;
    }
    addItems(fetchedItems);

    isFetchingRef.current = false;
  };

  
  // Restart pagination from start when watchedValues 
  useEffect(() => {
    pageNoRef.current = initialPageNo;
    clearAllItems();
    fetchDataRef.current = fetchData;
    loadNextPage();
  }, watchedValues);

  // Scroll pagination
  useEffect(() => {
    const handleScroll = () => {
      if (
        window.innerHeight + window.pageYOffset >=
        document.documentElement.offsetHeight - 1
      ) {
        loadNextPage();
      }
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return { items, loadNextPage };
}

export default usePagination;
