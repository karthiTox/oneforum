import { useState } from "react";

export default function useUniqueArrayState<T>(): [
  T[],
  (newElements: T[]) => void,
  () => void
] {
  const [array, setArray] = useState<T[]>([]);

  const addElemetsAndRemoveDuplicates = (newElements: T[]) => {
    setArray((prev) =>
      Array.from(
        new Set([...prev, ...newElements].map((v) => JSON.stringify(v)))
      ).map((v) => JSON.parse(v))
    );
  };

  const clearArray = () => {
    setArray([]);
  };

  return [array, addElemetsAndRemoveDuplicates, clearArray];
}
