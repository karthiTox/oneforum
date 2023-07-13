import { User } from ".";

export interface AuthData {
  user: User;
  token: string;
}