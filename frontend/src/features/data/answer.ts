import { User, UUID } from ".";
import { Vote } from "./vote";

export interface Answer {
  aid: UUID;
  question: UUID;
  owner: User;
  content: string;
  createdAt: string;
  votes: Vote[];
  totalVotes: number;
}
