import { User, UUID } from ".";

export interface Vote {
  answer: UUID;
  voter: User;
}
