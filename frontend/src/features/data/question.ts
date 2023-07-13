import { Topic } from "./topic";
import { User } from "./user";
import { UUID } from "./uuid";

export interface Question {
  qid: UUID;
  topic: Topic;
  owner: User;
  content: string;
  createdAt: string;
  totalAnswers: number;
}
