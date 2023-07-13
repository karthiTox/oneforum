import { UUID } from "./uuid";

export interface Topic {
  tid: UUID;
  topicName: string;
  totalQuestions: number;
}
